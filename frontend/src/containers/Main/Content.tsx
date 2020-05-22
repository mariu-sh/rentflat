import React from 'react';

import styled from 'styled-components';

const Wrapper = styled.div`
  background: white;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  margin-top: 32px;
  min-height: calc(90vh - 32px);
`;

const BoxWrapper = styled.div`
  border: 1px solid black;
  width: 20%;
  height: 250px;
  margin: 16px;
`;

function Content() {
  return (
    <Wrapper>
      <BoxWrapper>1</BoxWrapper>
      <BoxWrapper>2</BoxWrapper>
      <BoxWrapper>3</BoxWrapper>
      <BoxWrapper>4</BoxWrapper>
      <BoxWrapper>5</BoxWrapper>
      <BoxWrapper>6</BoxWrapper>
    </Wrapper>
  );
}

export default Content;
