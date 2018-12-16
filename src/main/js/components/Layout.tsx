import * as React from "react";
import {Container} from "reactstrap";
import {Search} from "./search/Search";
import {Results} from "./search/Results";
import {Selection} from "./search/Selection";
import {Header} from "./search/Header";

export interface LayoutProps {
  compiler: string;
  framework: string;
}

export interface LayoutState {
  results: [];
  selection: [];
}

// 'LayoutProps' describes the shape of props.
// State is never set so we use the '{}' type.
export class Layout extends React.Component<LayoutProps, LayoutState> {

  constructor(props: LayoutProps) {
    super(props);
    this.state = {
      results: [],
      selection: []
    };
  }

  // This just provide mock data to visualize concept
  componentDidMount() {
    fetch('/api/compounds/all', {credentials: 'same-origin',})
      .then((response) => {
        return response.json();
      })
      .then((results) => {
        this.setState({
          results: results,
          selection: results
        });
      })
      .catch((e) => {
        return e;
      });
  }

  render() {
    return (
      <Container fluid={true}>
        <Header/>
        <Search/>
        <Results results={this.state.results}/>
        <Selection results={this.state.selection}/>
      </Container>
    );
  }

}