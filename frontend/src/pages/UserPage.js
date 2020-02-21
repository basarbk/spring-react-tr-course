import React from 'react';
import ProfileCard from '../components/ProfileCard';

const UserPage = props => {
  return (
    <div className="container">
      <ProfileCard username={props.username} />
    </div>
  );
};

export default UserPage;
