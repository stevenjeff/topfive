import axios from 'axios';

axios.defaults.timeout = 6000;
axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.headers.get['Accepts'] = 'application/json';
export const axiosCon = axios;