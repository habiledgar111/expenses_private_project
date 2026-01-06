import { useState } from "react";
import "flowbite";

function DashboardCard({amount, judul}){

  const formatRupiah = (value) => {
    return new Intl.NumberFormat("id-ID",{
      style: "currency",
      currency: "IDR",
      minimumFractionDigits: 0,
    }).format(value);
  };
  return (
    <div className="bg-neutral-primary-soft w-full p-6 border border-default rounded-base shadow-xs flex flex-col items-center justify-center text-center">
      <h5 className="mb-3 text-2xl font-semibold tracking-tight text-heading leading-8">
        {judul}
      </h5>

      <p className="text-body mb-6">
        {formatRupiah(amount)}
      </p>
    </div>
  );
}

export default DashboardCard;