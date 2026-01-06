import {
  useReactTable,
  createColumnHelper,
  getCoreRowModel,
  flexRender,
} from "@tanstack/react-table";

const columnHelper = createColumnHelper();

const columns = [
  columnHelper.accessor("id", {
    header: "id",
    cell: ({ getValue }) => getValue(),
  }),

  columnHelper.accessor("transactionTime", {
    header: "transaction time",
    cell: ({ getValue }) => {
      const date = new Date(getValue());

      const tanggal = date.toLocaleDateString("id-ID", {
        day: "2-digit",
        month: "2-digit",
        year: "numeric",
      });

      const jam = date.toLocaleTimeString("id-ID", {
        hour: "2-digit",
        minute: "2-digit",
        hour12: false,
      });

      return `${tanggal} ${jam}`;
    },
  }),

  columnHelper.accessor("amount", {
    header: "amount",
    cell: ({ getValue }) =>
      new Intl.NumberFormat("id-ID", {
        style: "currency",
        currency: "IDR",
        minimumFractionDigits: 0,
      }).format(getValue()),
  }),

  columnHelper.accessor("type", {
    header: "type",
    cell: ({ getValue }) => getValue(),
  }),

  columnHelper.accessor("category", {
    header: "categoty",
    cell: ({ getValue }) => getValue(),
  }),

  columnHelper.accessor("description", {
    header: "description",
    cell: ({ getValue }) => getValue(),
  }),
];

function Table({ data }) {
  const table = useReactTable({
    data,
    columns,
    getCoreRowModel: getCoreRowModel(),
  });

  return (
    <div
      className="
        overflow-x-auto
        bg-white dark:bg-gray-800
        rounded-lg
        border border-gray-200 dark:border-gray-700"
    >
      <table className="min-w-full border-collapse text-sm">
        {/* HEADER */}
        <thead className="bg-gray-50 dark:bg-gray-700">
          {table.getHeaderGroups().map((headerGroups) => (
            <tr key={headerGroups.id}>
              {headerGroups.headers.map((header) => (
                <th
                  key={header.id}
                  className="
                    px-4 py-3 text-left font-medium
                    text-gray-700 dark:text-gray-200
                    border-b border-gray-200 dark:border-gray-600"
                >
                  {flexRender(
                    header.column.columnDef.header,
                    header.getContext()
                  )}
                </th>
              ))}
            </tr>
          ))}
        </thead>

        {/* BODY */}
        <tbody>
          {table.getRowModel().rows.map((row, index) => (
            <tr
              key={row.id}
              className={`
                ${
                  index % 2 === 0
                    ? "bg-white dark:bg-gray-800"
                    : "bg-gray-50 dark:bg-gray-700"
                }
                hover:bg-gray-100 dark:hover:bg-gray-600 transition-colors
              `}
            >
              {row.getVisibleCells().map((cell) => (
                <td
                  key={cell.id}
                  className="px-4 py-3 text-gray-800 dark:text-gray-100 border-b border-gray-200 dark:border-gray-600"
                >
                  {flexRender(cell.column.columnDef.cell, cell.getContext())}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Table;
