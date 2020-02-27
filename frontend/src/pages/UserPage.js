import React, { useState, useEffect } from 'react';
import ProfileCard from '../components/ProfileCard';
import { getUser } from '../api/apiCalls';
import { useParams } from 'react-router-dom';
import { useTranslation } from 'react-i18next';

const UserPage = () => {
  const [user, setUser] = useState({});
  const [notFound, setNotFound] = useState(false);

  const { username } = useParams();

  const { t } = useTranslation();

  useEffect(() => {
    setNotFound(false);
  }, [user]);

  useEffect(() => {
    const loadUser = async () => {
      try {
        const response = await getUser(username);
        setUser(response.data);
      } catch (error) {
        setNotFound(true);
      }
    };
    loadUser();
  }, [username]);

  if (notFound) {
    return (
      <div className="container">
        <div className="alert alert-danger text-center">
          <div>
            <i className="material-icons" style={{ fontSize: '48px' }}>
              error
            </i>
          </div>
          {t('User not found')}
        </div>
      </div>
    );
  }

  return (
    <div className="container">
      <ProfileCard user={user} />
    </div>
  );
};

export default UserPage;
