import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth-service';

export const bearerInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService)
  const token = authService.getToken();
  if (token != null) {
    //   console.log(token);

    const cloned = req.clone({
      // headers: req.headers.set('Authorization', "Bearer " + token),
    })

    return next(cloned)
    // return next(cloned)
  }
  return next(req);

};
