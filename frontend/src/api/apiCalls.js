import axios from 'axios';

export const signup = body => {
  return axios.post('/api/1.0/users', body, { headers: { 'accept-language': 'tr' } });
};
