import React from 'react';

import styled from 'styled-components';

const FooterWrapper = styled.div`
  background: #1293d4;
  min-height: 5vh;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function Footer() {
  return (
    <FooterWrapper>
      Made with <span style={{ color: '#e25555' }}>&#9829;</span>
    </FooterWrapper>
  );
}

export default Footer;
