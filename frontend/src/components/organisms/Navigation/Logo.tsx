import React from 'react';

import styled from 'styled-components';

const LogoImage = styled.div`
  width: 13%;
  background: black;
  height: 10vh;
  position: absolute;
`;

function Logo() {
  return <LogoImage>logo</LogoImage>;
}

export default Logo;
