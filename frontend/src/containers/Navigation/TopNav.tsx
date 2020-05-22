import React from 'react';

import styled from 'styled-components';

import nav from '../../_nav';

export interface INavigationInterface {
  text: string;
}

const WrapperTopNav = styled.div`
  background: #ececec;
  color: black;
  width: 100%;
  position: relative;
  box-shadow: 3px 5px 50px 3px #696969;
  justify-content: space-between;
  display: flex;
  padding: 12px;
  min-height: 5vh;
`;

const TopNavWrapper = styled.ul`
  display: flex;
  list-style-type: none;
  margin: 0;
  padding-left: 20px;
`;

const ListElement = styled.li`
  margin: 0 32px;
`;

const PointerWrapper = styled.div`
  cursor: pointer;
`;

function TopNav() {
  return (
    <WrapperTopNav>
      <TopNavWrapper>
        {nav.navigation.map((val: INavigationInterface) => {
          return (
            <ListElement>
              <PointerWrapper>{val.text}</PointerWrapper>
            </ListElement>
          );
        })}
      </TopNavWrapper>
      <PointerWrapper>Logout</PointerWrapper>
    </WrapperTopNav>
  );
}

export default TopNav;
