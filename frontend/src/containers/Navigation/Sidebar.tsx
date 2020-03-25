import React from 'react';

import './Sidebar.scss';

export interface IMenuInterface {
  menuState: boolean;
}

class Sidebar extends React.Component<{}, IMenuInterface> {
  constructor(props: any) {
    super(props);
    this.state = {
      menuState: true
    };
  }

  handleMenu = (): void => {
    this.setState({
      menuState: !this.state.menuState
    });
  };

  render() {
    const { menuState } = this.state;
    return (
      <div>
        <nav
          className={menuState ? 'menu-nav--show' : 'menu-nav--hide'}
          onClick={this.handleMenu}
        >
          <p className="text-color font-big">dupa</p>
        </nav>
        <p onClick={this.handleMenu}>click</p>
      </div>
    );
  }
}

export default Sidebar;
