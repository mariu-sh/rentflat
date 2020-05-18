import React from 'react';

import './App.scss';
import styled from 'styled-components';

import TopNav from './containers/Navigation/TopNav';
import Content from './containers/Main/Content';
import Footer from './containers/Footer/Footer';

const Wrapper = styled.div`
  height: 80vh;
`;

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <TopNav />
        <Wrapper>
          <Content />
          <Footer />
        </Wrapper>
      </div>
    );
  }
}
export default App;
