import Navbar from "../component/navbar";
import DashboardCard from "../component/dashboardCard";
import Table from "../component/table";
import { Transactions } from "../dummy/tabledummy";

function Dashboard() {
  return (
    <div>
      <div className="grid grid-cols-2 gap-8 p-6">
        <DashboardCard amount={1000} judul={"Test 1"} />
        <DashboardCard amount={2000} judul={"Test 2"} />
      </div>
      <div className="mt-8 p-6">
        <Table data={Transactions} />
      </div>
    </div>
  );
}
export default Dashboard;
