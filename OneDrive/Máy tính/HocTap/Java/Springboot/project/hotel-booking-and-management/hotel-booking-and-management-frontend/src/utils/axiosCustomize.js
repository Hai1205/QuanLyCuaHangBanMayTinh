import axios from "axios";
import NProgress from "nprogress";
import AuthChecker from "./AuthChecker";

NProgress.configure({
  showSpinner: false,
  // easing: 'ease',
  // speed: 500,
  // trickle: true,
  // trickleRate: 0.5,
  trickleSpeed: 100,
});

const instance = axios.create({
  baseURL: process.env.REACT_APP_SERVER_URL,
  withCredentials: true,
  headers: {
    accept: "application/json",
  },
});

// Add a request interceptor
instance.interceptors.request.use(
  function (config) {
    NProgress.start();

    if (AuthChecker.token) {
      config.headers.Authorization = `Bearer ${AuthChecker.token}`;
    }

    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

// Add a response interceptor
instance.interceptors.response.use(
  function (response) {
    NProgress.done();
    return response;
  },
  function (error) {
    return error &&
      error.response &&
      error.response.data &&
      error.response.data.message
      ? error.response.data.message
      : Promise.reject(error);
  }
);

export default instance;