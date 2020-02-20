import React, { Component } from 'react';
import axios from 'axios';

class ApiProgress extends Component {
  state = {
    pendingApiCall: false
  };

  componentDidMount() {
    axios.interceptors.request.use(request => {
      this.setState({ pendingApiCall: true });
      return request;
    });

    axios.interceptors.response.use(
      response => {
        this.setState({ pendingApiCall: false });
        return response;
      },
      error => {
        this.setState({ pendingApiCall: false });
        throw error;
      }
    );
  }

  render() {
    const { pendingApiCall } = this.state;
    return <div>{React.cloneElement(this.props.children, { pendingApiCall })}</div>;
  }
}

export default ApiProgress;
