import React from "react";
import "./App.css";

import Sidebar from "./containers/Navigation/Sidebar";
import TopNav from "./containers/Navigation/TopNav";

function App() {
  return (
    <div className="App">
      <TopNav />
      <Sidebar />
    </div>
  );
}
export default App;
