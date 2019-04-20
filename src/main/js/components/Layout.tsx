import * as React from "react";
import {Container} from "reactstrap";
import {Search} from "./search/Search";
import {SearchResults} from "./search/SearchResults";
import {CompoundsForm} from "./CompoundsForm";
import {Header} from "./Header";
import {Calculations} from "./Calculations";
import {NotesAndAdvices} from "./NotesAndAdvices";

export interface LayoutProps {
  compiler: string;
  framework: string;
}

export interface LayoutState {
  results: [];
  selection: [];
  calculations: [];
  notes: [];
}

// 'LayoutProps' describes the shape of props.
// State is never set so we use the '{}' type.
export class Layout extends React.Component<LayoutProps, any> {

  constructor(props: LayoutProps) {
    super(props);

    this.state = {
      results: [],
      selection: [],
      calculations: [],
      notes: []
    };
  }

  render() {
    return (
      <Container fluid={true}>
        <Header/>
        <Search onChange={(e: any) => {this.handleUpdateResults(e)}}/>
        <SearchResults results={this.state.results} onChange={(e: number) => {this.handleAddResult(e)}}/>
        <CompoundsForm selection={this.state.selection} onChange={(e: number) => {this.handleRemoveSelected(e)}}/>
        <Calculations  calculations={this.state.calculations} />
        <NotesAndAdvices notes={this.state.notes}/>
      </Container>
    );
  }

  private handleUpdateResults(results: any) : void {
    this.setState({ results: results });
  }

  private handleAddResult(resultIndex: number) : void {
    const candidate = this.state.results[resultIndex];

    if (!this.state.selection.find((c: any) => c.name === candidate.name)){
      let results = this.state.selection.slice();
      results.push(candidate);
      this.setState({selection: results})
    }
  }

  private handleRemoveSelected(resultIndex: number) {
    let results = this.state.selection.slice();
    results.splice(this.state.results[resultIndex], 1);
    this.setState({selection: results})
  }

}