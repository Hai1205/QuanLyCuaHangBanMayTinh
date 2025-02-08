import React from 'react';
import { Navigate, useLocation } from 'react-router-dom';
import AuthChecker from "./AuthChecker";

export const ProtectedRoute = ({ element: Component }) => {
  const location = useLocation();

  return AuthChecker.isAuthenticated() ? (
    Component
  ) : (
    <Navigate to="/login" replace state={{ from: location }} />
  );
};

export const AdminRoute = ({ element: Component }) => {
  const location = useLocation();

  return AuthChecker.isAdmin() ? (
    Component
  ) : (
    <Navigate to="/login" replace state={{ from: location }} />
  );
};