import React, { Component } from 'react';
import { getUsers } from '../api/apiCalls';
import { withTranslation } from 'react-i18next';
import UserListItem from './UserListItem';

class UserList extends Component {
  state = {
    users: []
  };

  componentDidMount() {
    getUsers().then(response => {
      this.setState({
        users: response.data.content
      });
    });
  }

  render() {
    const { t } = this.props;
    const { users } = this.state;
    return (
      <div className="card">
        <h3 className="card-header text-center">{t('Users')}</h3>
        <div className="list-group-flush">
          {users.map(user => (
            <UserListItem key={user.username} user={user} />
          ))}
        </div>
      </div>
    );
  }
}

export default withTranslation()(UserList);
