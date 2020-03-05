import React from "react";

import styled from "styled-components";

import "./Sidebar.scss";

const Wrapper = styled.nav`
  background: #f3f3f3;
  width: 13%;

  @media (max-width: 800px) {
    background: black;
  }
`;

function Sidebar() {
  return (
    <Wrapper>
      <p className="text-color font-big">nav</p>
    </Wrapper>
  );
}

export default Sidebar;
