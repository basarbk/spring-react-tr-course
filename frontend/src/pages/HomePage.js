import React from 'react';
import UserList from '../components/UserList';
import HoaxSubmit from '../components/HoaxSubmit';
import { useSelector } from 'react-redux';

const HomePage = () => {
  const { isLoggedIn } = useSelector(store => ({ isLoggedIn: store.isLoggedIn }));
  return (
    <div className="container">
      <div className="row">
        <div className="col">{isLoggedIn && <HoaxSubmit />}</div>
        <div className="col">
          <UserList />
        </div>
      </div>
    </div>
  );
};

export default HomePage;
