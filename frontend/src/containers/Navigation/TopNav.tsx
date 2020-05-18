import React from 'react';

import styled from 'styled-components';

const WrapperTopNav = styled.div`
  background: #ececec;
  color: black;
  width: 100%;
  position: relative;
  box-shadow: 3px 5px 50px 3px #696969;
`;

const TopNavWrapper = styled.ul`
  display: flex;
  list-style-type: none;
  margin-top: 0;
  padding-left: 0;
`;

const ListElement = styled.li`
  border: 3px solid black; /* for test */
  margin: 8px 16px;
`;

function TopNav() {
  return (
    <WrapperTopNav>
      <TopNavWrapper>
        <ListElement>abcd</ListElement>
        <ListElement>abcd</ListElement>
        <ListElement>abcd</ListElement>
      </TopNavWrapper>
    </WrapperTopNav>
  );
}

export default TopNav;
