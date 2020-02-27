import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import { useSelector } from 'react-redux';
import ProfileImageWithDefault from './ProfileImageWithDefault';
import { useTranslation } from 'react-i18next';
import Input from './Input';

const ProfileCard = props => {
  const [inEditMode, setInEditMode] = useState(false);
  const { username: loggedInUsername } = useSelector(store => ({ username: store.username }));
  const routeParams = useParams();

  const { t } = useTranslation();

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
        {!inEditMode && (
          <>
            <h3>
              {displayName}@{username}
            </h3>
            <button className="btn btn-success d-inline-flex" onClick={() => setInEditMode(true)}>
              <i className="material-icons">edit</i>
              {t('Edit')}
            </button>
          </>
        )}
        {inEditMode && (
          <div>
            <Input label={t('Change Display Name')} />
            <div>
              <button className="btn btn-primary d-inline-flex">
                <i className="material-icons">save</i>
                {t('Save')}
              </button>
              <button className="btn btn-light d-inline-flex ml-1" onClick={() => setInEditMode(false)}>
                <i className="material-icons">close</i>
                {t('Cancel')}
              </button>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default ProfileCard;
