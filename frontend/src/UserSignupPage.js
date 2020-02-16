import React from 'react';
import axios from 'axios';

class UserSignupPage extends React.Component {
  state = {
    username: null,
    displayName: null,
    password: null,
    passwordRepeat: null,
    pendingApiCall: false
  };

  onChange = event => {
    const { name, value } = event.target;
    this.setState({
      [name]: value
    });
  };

  onClickSignup = event => {
    event.preventDefault();

    const { username, displayName, password } = this.state;

    const body = {
      username,
      displayName,
      password
    };
    this.setState({ pendingApiCall: true });

    axios
      .post('/api/1.0/users', body)
      .then(response => {
        this.setState({ pendingApiCall: false });
      })
      .catch(error => {
        this.setState({ pendingApiCall: false });
      });
  };

  render() {
    return (
      <div className="container">
        <form>
          <h1 className="text-center">Sign Up</h1>
          <div className="form-group">
            <label>Username</label>
            <input className="form-control" name="username" onChange={this.onChange} />
          </div>
          <div className="form-group">
            <label>Display Name</label>
            <input className="form-control" name="displayName" onChange={this.onChange} />
          </div>
          <div className="form-group">
            <label>Password</label>
            <input className="form-control" name="password" type="password" onChange={this.onChange} />
          </div>
          <div className="form-group">
            <label>Password Repeat</label>
            <input className="form-control" name="passwordRepeat" type="password" onChange={this.onChange} />
          </div>
          <div className="text-center">
            <button className="btn btn-primary" onClick={this.onClickSignup} disabled={this.state.pendingApiCall}>
              {this.state.pendingApiCall && <span className="spinner-border spinner-border-sm"></span>} Sign Up
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default UserSignupPage;
