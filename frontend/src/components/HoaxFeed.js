import React, { useState, useEffect } from 'react';
import { getHoaxes } from '../api/apiCalls';
import { useTranslation } from 'react-i18next';

const HoaxFeed = () => {
  const [hoaxPage, setHoaxPage] = useState({ content: [] });
  const { t } = useTranslation();

  useEffect(() => {
    const loadHoaxes = async () => {
      try {
        const response = await getHoaxes();
        setHoaxPage(response.data);
      } catch (error) {}
    };
    loadHoaxes();
  }, []);
  if (hoaxPage.content.length === 0) {
    return <div className="alert alert-secondary text-center">{t('There are no hoaxes')}</div>;
  }

  return <div></div>;
};

export default HoaxFeed;
