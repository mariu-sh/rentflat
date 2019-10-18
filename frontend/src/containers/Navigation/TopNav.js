import React from "react";

import styled from "styled-components";
import Logo from "../../components/Navigation/Logo";

const WrapperTopNav = styled.div`
  background: #2b7de9;
  color: white;
  width: 100%;
  height: 10vh;
  position: relative;
`;

function TopNav() {
  return (
    <WrapperTopNav>
      <Logo />
      topbar nav
    </WrapperTopNav>
  );
}

export default TopNav;
