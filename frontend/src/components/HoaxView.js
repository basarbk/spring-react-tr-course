import React from 'react';

const HoaxView = props => {
  const { hoax } = props;
  return <div className="card p-1">{hoax.content}</div>;
};

export default HoaxView;
