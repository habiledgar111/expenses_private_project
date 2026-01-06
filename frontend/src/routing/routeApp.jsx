import { Routes, Route } from "react-router-dom";
import Login from "../page/login";
import Test from "../page/test";
import Dashboard from "../page/dashboard";
import AddTransaction from "../page/addTransaction";
import Page404 from "../page/page404";
import DarkModeLayout from "../page/darkmodelayout";

function RouteApp() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Login />} />

        <Route element={<DarkModeLayout />}>
          <Route path="/test" element={<Test />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/addTransaction" element={<AddTransaction />} />
        </Route>

        <Route path="*" element={<Page404 />} />
      </Routes>
    </>
  );
}

export default RouteApp;
