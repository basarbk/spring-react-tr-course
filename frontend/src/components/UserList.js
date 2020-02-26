import React, { useState, useEffect } from 'react';
import { getUsers } from '../api/apiCalls';
import { useTranslation } from 'react-i18next';
import UserListItem from './UserListItem';

const UserList = () => {
  const [page, setPage] = useState({
    content: [],
    size: 3,
    number: 0
  });

  useEffect(() => {
    loadUsers();
  }, []);

  const onClickNext = () => {
    const nextPage = page.number + 1;
    loadUsers(nextPage);
  };

  const onClickPrevious = () => {
    const previousPage = page.number - 1;
    loadUsers(previousPage);
  };

  const loadUsers = page => {
    getUsers(page).then(response => {
      setPage(response.data);
    });
  };

  const { t } = useTranslation();
  const { content: users, last, first } = page;
  return (
    <div className="card">
      <h3 className="card-header text-center">{t('Users')}</h3>
      <div className="list-group-flush">
        {users.map(user => (
          <UserListItem key={user.username} user={user} />
        ))}
      </div>
      <div>
        {first === false && (
          <button className="btn btn-sm btn-light" onClick={onClickPrevious}>
            {t('Previous')}
          </button>
        )}
        {last === false && (
          <button className="btn btn-sm btn-light float-right" onClick={onClickNext}>
            {t('Next')}
          </button>
        )}
      </div>
    </div>
  );
};

export default UserList;
