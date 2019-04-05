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
export class Layout extends React.Component<any, any> {

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
        <Results results={this.state.results} onChange={(e: number) => {this.handleAddResult(e)}}/>
        <Selection results={this.state.selection} onChange={(e: number) => {this.handleRemoveSelected(e)}}/>
      </Container>
    );
  }

  private handleUpdateResults(results: any) : void {
    this.setState({ results: results });
  }

  private handleAddResult(resultIndex: number) : void {
    let results = this.state.selection.slice();
    results.push(this.state.results[resultIndex]);
    this.setState({selection: results})
  }

  private handleRemoveSelected(resultIndex: number) {
    let results = this.state.selection.slice();
    results.splice(this.state.results[resultIndex], 1);
    this.setState({selection: results})
  }
  
}