import React from 'react';
import { useParams } from 'react-router-dom';
import { useSelector } from 'react-redux';
import ProfileImageWithDefault from './ProfileImageWithDefault';

const ProfileCard = props => {
  const { username: loggedInUsername } = useSelector(store => ({ username: store.username }));
  const routeParams = useParams();

  const { user } = props;
  const { username, displayName, image } = user;

  const pathUsername = routeParams.username;
  let message = 'We cannot edit';
  if (pathUsername === loggedInUsername) {
    message = 'We can edit';
  }

  return (
    <div className="card text-center">
      <div className="card-header">
        <ProfileImageWithDefault className="rounded-circle shadow" width="200" height="200" alt={`${username} profile`} image={image} />
      </div>
      <div className="card-body">
        <h3>
          {displayName}@{username}
        </h3>
      </div>
    </div>
  );
};

export default ProfileCard;
