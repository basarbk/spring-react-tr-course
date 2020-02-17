import axios from 'axios';

export const signup = body => {
  return axios.post('/api/1.0/users', body);
};

export const changeLanguage = language => {
  axios.defaults.headers['accept-language'] = language;
};
