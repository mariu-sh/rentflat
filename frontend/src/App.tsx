import React from 'react';

import './App.css';
import styled from 'styled-components';

import Sidebar from './containers/Navigation/Sidebar';
import TopNav from './containers/Navigation/TopNav';
import Content from './containers/Main/Content';
import Footer from './containers/Footer/Footer';

const Wrapper = styled.div`
  display: flex;
  min-height: 85vh;
`;

function App() {
  return (
    <div className="App">
      <TopNav />
      <Wrapper>
        <Sidebar />
        <Content />
      </Wrapper>
      <Footer />
    </div>
  );
}
export default App;
