import React from 'react';
import defaultPicture from '../assets/profile.png';

const ProfileImageWithDefault = props => {
  const { image, tempimage } = props;

  let imageSource = defaultPicture;
  if (image) {
    imageSource = 'images/profile/' + image;
  }
  return (
    <img
      alt={`Profile`}
      src={tempimage || imageSource}
      {...props}
      onError={event => {
        event.target.src = defaultPicture;
      }}
    />
  );
};

export default ProfileImageWithDefault;
