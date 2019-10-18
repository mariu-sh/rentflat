import React from "react";

import styled from "styled-components";

const WrapperTopNav = styled.div`
  background: black;
  color: white;
  width: 100%;
  height: 10vh;
`;

function TopNav() {
  return <WrapperTopNav>topbar nav</WrapperTopNav>;
}

export default TopNav;
