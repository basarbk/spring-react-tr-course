import React, { Component } from 'react';
import axios from 'axios';

class ApiProgress extends Component {
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
    if (url === this.props.path) {
      this.setState({ pendingApiCall: inProgress });
    }
  };

  render() {
    const { pendingApiCall } = this.state;
    return <div>{React.cloneElement(this.props.children, { pendingApiCall })}</div>;
  }
}

export default ApiProgress;
