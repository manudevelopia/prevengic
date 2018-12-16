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

  render() {
    return (
      <Container fluid={true}>
        <Header/>
        <Search onChange={(e: any) => {this.handleUpdateResults(e)}}/>
        <Results results={this.state.results}/>
        <Selection results={this.state.selection}/>
      </Container>
    );
  }

  private handleUpdateResults(results: any) : void {
    this.setState({ results: results });
  }
  
}