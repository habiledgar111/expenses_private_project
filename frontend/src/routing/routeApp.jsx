import { Routes, Route } from "react-router-dom";
import Login from "../page/login";
import Test from "../page/test";
import Dashboard from "../page/dashboard";
import Page404 from "../page/page404";

function RouteApp() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/test" element={<Test />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="*" element={<Page404 />} />
    </Routes>
  );
}

export default RouteApp;
