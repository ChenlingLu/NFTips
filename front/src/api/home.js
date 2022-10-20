import request from '@/utils/request';

export default class HomeApi {
  static fetchAll = () => request.get(`/api/users/list`);
};
