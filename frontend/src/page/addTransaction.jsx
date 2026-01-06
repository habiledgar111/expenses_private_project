import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

const TransactionSchema = z.object({
  amount: z.coerce.number().positive("Amount harus lebih dari 0"),
  type: z.enum(["INCOME", "EXPENSE"]),
  category: z.string().min(1, "Category wajib diisi").max(20),
  description: z.string().min(1, "Description wajib diisi").max(50),
  transactionTime: z.string().min(1, "Tanggal wajib diisi"),
});

function AddTransaction() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: zodResolver(TransactionSchema),
  });

  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <div className="min-h-screen flex items-center justify-center px-4">
      <div className="
        w-full max-w-md
        bg-white dark:bg-gray-800
        rounded-xl shadow-lg
        p-8
      ">
        <h2 className="text-2xl font-semibold text-center mb-6
          text-gray-800 dark:text-gray-100">
          Add Transaction
        </h2>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">

          {/* Amount */}
          <div>
            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300">
              Amount
            </label>
            <input
              type="number"
              {...register("amount")}
              className="
                w-full rounded-lg border
                border-gray-300 dark:border-gray-600
                bg-white dark:bg-gray-700
                text-gray-800 dark:text-gray-100
                px-3 py-2
                focus:outline-none focus:ring-2 focus:ring-blue-500
              "
            />
            {errors.amount && (
              <p className="text-red-500 text-sm mt-1">
                {errors.amount.message}
              </p>
            )}
          </div>

          {/* Type */}
          <div>
            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300">
              Type
            </label>
            <select
              {...register("type")}
              className="
                w-full rounded-lg border
                border-gray-300 dark:border-gray-600
                bg-white dark:bg-gray-700
                text-gray-800 dark:text-gray-100
                px-3 py-2
                focus:outline-none focus:ring-2 focus:ring-blue-500
              "
            >
              <option value="INCOME">INCOME</option>
              <option value="EXPENSE">EXPENSE</option>
            </select>
          </div>

          {/* Category */}
          <div>
            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300">
              Category
            </label>
            <input
              {...register("category")}
              className="w-full rounded-lg border border-gray-300 dark:border-gray-600 bg-white dark:bg-gray-700 px-3 py-2 text-gray-800 dark:text-gray-100 focus:ring-2 focus:ring-blue-500"
            />
          </div>

          {/* Description */}
          <div>
            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300">
              Description
            </label>
            <input
              {...register("description")}
              className="w-full rounded-lg border border-gray-300 dark:border-gray-600 bg-white dark:bg-gray-700 px-3 py-2 text-gray-800 dark:text-gray-100 focus:ring-2 focus:ring-blue-500"
            />
          </div>

          {/* Date */}
          <div>
            <label className="block text-sm font-medium text-gray-700 dark:text-gray-300">
              Transaction Date
            </label>
            <input
              type="date"
              {...register("transactionTime")}
              className="w-full rounded-lg border border-gray-300 dark:border-gray-600 bg-white dark:bg-gray-700 px-3 py-2 text-gray-800 dark:text-gray-100 focus:ring-2 focus:ring-blue-500"
            />
          </div>

          {/* Button */}
          <button
            type="submit"
            className="
              w-full py-2 rounded-lg
              bg-blue-600 hover:bg-blue-700
              text-white font-medium
              transition
            "
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}

export default AddTransaction;
