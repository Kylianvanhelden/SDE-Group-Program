class RendererBridge {
  private final Renderer renderer;

  public RendererBridge(Renderer renderer) {
    this.renderer = renderer;
  }

  public void display() {
    renderer.render();
  }
}