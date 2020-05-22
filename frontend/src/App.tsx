import React from 'react';

import './App.scss';

import TopNav from './containers/Navigation/TopNav';
import Content from './containers/Main/Content';
import Footer from './containers/Footer/Footer';

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <TopNav />
        <Content />
        <Footer />
      </div>
    );
  }
}
export default App;
