import { useState } from "react";
import { Link } from "react-router-dom";

function Page404() {
  const [pos, setPos] = useState({ x: 0, y: 0 });

  return (
    <div
      className="relative min-h-screen bg-black overflow-hidden"
      onMouseMove={(e) => {
        setPos({ x: e.clientX, y: e.clientY });
      }}
    >
      <div
        className="absolute inset-0 flex flex-col items-center justify-center text-center text-white"
        style={{
          WebkitMaskImage: `radial-gradient(
            circle 160px at ${pos.x}px ${pos.y}px,
            white 0%,
            transparent 70%
          )`,
          maskImage: `radial-gradient(
            circle 160px at ${pos.x}px ${pos.y}px,
            white 0%,
            transparent 70%
          )`,
        }}
      >
        <h1 className="text-[160px] font-extrabold tracking-widest">404</h1>
        <p className="text-xl opacity-80">
          Page not found
        </p>

        <Link
          to="/dashboard"
          className="mt-8 inline-block rounded-lg bg-white px-6 py-3 text-black font-semibold hover:bg-gray-200 transition"
        >
          Back to Home
        </Link>
      </div>

      <div className="absolute bottom-6 w-full text-center text-gray-400 text-sm">
        Move your mouse to find the page 🔦
      </div>
    </div>
  );
}

export default Page404;
