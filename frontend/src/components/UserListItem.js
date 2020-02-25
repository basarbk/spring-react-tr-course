import React from 'react';
import defaultPicture from '../assets/profile.png';
import { Link } from 'react-router-dom';

const UserListItem = props => {
  const { user } = props;
  const { username, displayName, image } = user;
  let imageSource = defaultPicture;
  if (image) {
    imageSource = image;
  }

  return (
    <Link to={`/user/${username}`} className="list-group-item list-group-item-action">
      <img className="rounded-circle" width="32" height="32" alt={`${username} profile`} src={imageSource} />
      <span className="pl-2">
        {displayName}@{username}
      </span>
    </Link>
  );
};

export default UserListItem;
