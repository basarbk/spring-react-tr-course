import React, { Component } from 'react';
import axios from 'axios';

function getDisplayName(WrappedComponent) {
  return WrappedComponent.displayName || WrappedComponent.name || 'Component';
}

export function withApiProgress(WrappedComponent, apiPath) {
  return class extends Component {
    static displayName = `ApiProgress(${getDisplayName(WrappedComponent)})`;

    state = {
      pendingApiCall: false
    };

    componentDidMount() {
      axios.interceptors.request.use(request => {
        this.updateApiCallFor(request.url, true);
        return request;
      });

      axios.interceptors.response.use(
        response => {
          this.updateApiCallFor(response.config.url, false);
          return response;
        },
        error => {
          this.updateApiCallFor(error.config.url, false);
          throw error;
        }
      );
    }

    updateApiCallFor = (url, inProgress) => {
      if (url === apiPath) {
        this.setState({ pendingApiCall: inProgress });
      }
    };

    render() {
      const { pendingApiCall } = this.state;
      return <WrappedComponent pendingApiCall={pendingApiCall} {...this.props} />;
    }
  };
}
