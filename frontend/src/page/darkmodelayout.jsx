import { useEffect, useState } from "react";
import Navbar from "../component/navbar";
import { Outlet } from "react-router-dom";

function DarkModeLayout(){
  const [dark,setDark] = useState(false);

  useEffect(() => {
    const saved = localStorage.getItem("theme");
    if (saved === "dark") setDark(true);
  }, []);

  useEffect(() => {
    if (dark) {
      document.documentElement.classList.add("dark");
      localStorage.setItem("theme", "dark");
    } else {
      document.documentElement.classList.remove("dark");
      localStorage.setItem("theme", "light");
    }
  }, [dark]);

  return (
    <div>
      <Navbar dark={dark} setDark={setDark} />

      <main className="
        pt-20 min-h-screen
        bg-gray-100 dark:bg-gray-900
      ">
        <Outlet />
      </main>
    </div>
  );
}
export default DarkModeLayout;