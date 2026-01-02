import Sidebar from "../component/sidebar";

function Dashboard() {
  return (
    <div className="min-h-screen bg-gray-100">
      <Sidebar />
      <main className="pt-20 px-4">
        <div className="grid grid-cols-3 gap-8">
          <div>01</div>
          <div>02</div>
          <div>03</div>
        </div>
      </main>
    </div>
  );
}
export default Dashboard;
