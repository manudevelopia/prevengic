import * as React from "react";
import {Container} from "reactstrap";
import {Search} from "./search/Search";
import {SearchResults} from "./search/SearchResults";
import {CompoundsForm} from "./CompoundsForm";
import {Header} from "./Header";
import {Exposition} from "./Exposition";
import {NotesAndAdvices} from "./NotesAndAdvices";
import {Notes} from "./Notes";
import {WarningAdvices} from "./WarningAdvices";
import {ShortExposition} from "./ShortExposition";

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
      notes: [],
      warningAdvices: []
    };
  }

  render() {
    return (
      <Container fluid={true}>
        <Header/>
        <Search onChange={(e: any) => {this.handleUpdateResults(e)}}/>
        <SearchResults results={this.state.results} onChange={(e: number) => {this.handleAddResult(e)}}/>
        <CompoundsForm selection={this.state.selection}
                       onChange={(e: number) => {
                         this.handleRemoveSelected(e)
                       }}
                       onUpdate={(e: any) => {
                         this.handleUpdate(e)
                       }}/>
        <Exposition calculations={this.state.calculations}/>
        <ShortExposition calculations={this.state.calculations}/>
        <NotesAndAdvices results={this.state.calculations}/>
        <WarningAdvices warningAdvices={this.state.warningAdvices}/>
        <Notes notes={this.state.notes}/>
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

  private handleUpdate(report: any) {
    this.setState({
        calculations: report.compoundReportResults,
        notes: report.notes,
        warningAdvices: report.warningAdvices
    });
  }

}