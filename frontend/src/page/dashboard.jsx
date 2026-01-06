import DashboardCard from "../component/dashboardCard";
import Table from "../component/table";
import { Transactions } from "../dummy/tabledummy";
import { useState, useMemo } from "react";

function Dashboard() {
  const [selectedDate, setSelectedDate] = useState("");

  const filteredData = useMemo(() => {
    if (!selectedDate) return Transactions;

    const selected = new Date(selectedDate);
    const selectedMonth = selected.getMonth() + 1;
    const selectedYear = selected.getFullYear();

    return Transactions.filter((t) => {
      const date = new Date(t.transactionTime); // pastikan t.date berupa string
      return date.getFullYear() === selectedYear && date.getMonth() + 1 === selectedMonth;
    });
  }, [selectedDate]);

  return (
    <div>

      <div className="grid grid-cols-2 gap-8 p-6">
        <DashboardCard amount={1000} judul={"Test 1"} />
        <DashboardCard amount={2000} judul={"Test 2"} />
      </div>

      <div className="mb-4 px-6 flex flex-col">
        <label className="text-sm font-medium text-gray-700 dark:text-gray-300 mb-1">
          Pilih Tanggal
        </label>
        <input
          type="date"
          value={selectedDate}
          onChange={(e) => setSelectedDate(e.target.value)}
          className="border rounded px-2 py-1 w-40 text-gray-700 dark:text-gray-300"
        />
      </div>

      <div className="p-6">
      <Table data={filteredData} />
      </div>
    </div>
  );
}
export default Dashboard;
