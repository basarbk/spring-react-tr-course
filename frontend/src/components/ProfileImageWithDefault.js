import React from 'react';
import defaultPicture from '../assets/profile.png';

const ProfileImageWithDefault = props => {
  const { image, tempImage } = props;

  let imageSource = defaultPicture;
  if (image) {
    imageSource = image;
  }
  return <img alt={`Profile`} src={tempImage || imageSource} {...props} />;
};

export default ProfileImageWithDefault;
