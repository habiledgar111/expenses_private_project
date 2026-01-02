function Test() {
  return (
    <div className="p-6">
      <button
        data-modal-target="test-modal"
        data-modal-toggle="test-modal"
        className="px-4 py-2 bg-blue-600 text-white rounded"
      >
        Open Modal
      </button>

      <div
        id="test-modal"
        tabIndex="-1"
        className="hidden fixed inset-0 z-50 flex items-center justify-center bg-black/50"
      >
        <div className="bg-white rounded-lg p-6">
          <h3 className="text-lg font-semibold mb-4">Flowbite OK</h3>

          <button
            data-modal-hide="test-modal"
            className="px-3 py-2 bg-red-500 text-white rounded"
          >
            Close
          </button>
        </div>
      </div>
    </div>
  );
}

export default Test;
