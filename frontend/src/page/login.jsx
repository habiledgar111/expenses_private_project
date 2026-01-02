import "flowbite";
import { useState } from "react";

function Login() {
  const [username,setUsername] = useState("");
  const [password,setPassword] = useState("");
  const [loading,setLoading] = useState(false);

function handleSubmit(e){
  e.preventDefault();
  setLoading(true);
  setTimeout(() => {
    setLoading(false);
    console.log("Username: ",username);
    console.log("Password: ",password);
  }, 5000);
}
  
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="w-full max-w-sm bg-neutral-primary-soft p-6 border border-default rounded-base shadow-xs">
        <form onSubmit={handleSubmit}>
          <h5 className="text-xl font-semibold text-heading mb-6">
            Sign In to our platform
          </h5>

          <div className="mb-4">
            <label
              htmlFor="username"
              className="block mb-2.5 text-sm font-medium text-heading"
            >
              Your Username
            </label>
            <input
              type="text"
              id="username"
              className="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body"
              placeholder="exampleusername"
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>

          <div>
            <label
              htmlFor="password"
              className="block mb-2.5 text-sm font-medium text-heading"
            >
              Your password
            </label>
            <input
              type="password"
              id="password"
              className="bg-neutral-secondary-medium border border-default-medium text-heading text-sm rounded-base focus:ring-brand focus:border-brand block w-full px-3 py-2.5 shadow-xs placeholder:text-body"
              placeholder="•••••••••"
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <div className="flex items-start my-6">
            <div className="flex items-center">
              <input
                id="checkbox-remember"
                type="checkbox"
                className="w-4 h-4 border border-default-medium rounded-xs bg-neutral-secondary-medium focus:ring-2 focus:ring-brand-soft"
              />
              <label
                htmlFor="checkbox-remember"
                className="ms-2 text-sm font-medium text-heading"
              >
                Remember me
              </label>
            </div>
            <a
              href="#"
              className="ms-auto text-sm font-medium text-fg-brand hover:underline"
            >
              Lost Password?
            </a>
          </div>

          <button
            type="submit"
            disabled={loading}
            className="relative text-white bg-brand hover:bg-brand-strong focus:ring-4 focus:ring-brand-medium shadow-xs font-medium rounded-base text-sm px-4 py-2.5 w-full mb-3"
          >
            {loading && (
              <span className="absolute inset-0 flex items-center justify-center">
                <span className="w-4 h-4 border-2 border-white border-t-transparent rounded-full animate-spin" />
              </span>
            )}
            <span className={loading ? "opacity-0" : "opacity-100"}>
            Login to your account
            </span>
          </button>

          <div className="text-sm font-medium text-body">
            Not registered?{" "}
            <a href="#" className="text-fg-brand hover:underline">
              Create account
            </a>
          </div>
        </form>
      </div>
    </div>
  );
}
export default Login;
